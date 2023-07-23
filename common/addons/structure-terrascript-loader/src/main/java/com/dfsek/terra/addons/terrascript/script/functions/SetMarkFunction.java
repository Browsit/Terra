/*
 * Copyright (c) 2020-2021 Polyhedral Development
 *
 * The Terra Core Addons are licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in this module's root directory.
 */

package com.dfsek.terra.addons.terrascript.script.functions;

import net.jafama.FastMath;

import com.dfsek.terra.addons.terrascript.parser.lang.ImplementationArguments;
import com.dfsek.terra.addons.terrascript.parser.lang.Expression;
import com.dfsek.terra.addons.terrascript.parser.lang.Scope;
import com.dfsek.terra.addons.terrascript.parser.lang.functions.Function;
import com.dfsek.terra.addons.terrascript.script.TerraImplementationArguments;
import com.dfsek.terra.addons.terrascript.tokenizer.SourcePosition;
import com.dfsek.terra.api.util.RotationUtil;
import com.dfsek.terra.api.util.vector.Vector2;
import com.dfsek.terra.api.util.vector.Vector3;


public class SetMarkFunction implements Function<Void> {
    private final Expression<Number> x, y, z;
    private final SourcePosition position;
    private final Expression<String> mark;
    
    public SetMarkFunction(Expression<Number> x, Expression<Number> y, Expression<Number> z, Expression<String> mark, SourcePosition position) {
        this.position = position;
        this.mark = mark;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public Void evaluate(ImplementationArguments implementationArguments, Scope scope) {
        TerraImplementationArguments arguments = (TerraImplementationArguments) implementationArguments;
        Vector2 xz = RotationUtil.rotateVector(Vector2.of(x.evaluate(implementationArguments, scope).doubleValue(),
                                                          z.evaluate(implementationArguments, scope).doubleValue()), arguments.getRotation());
        
        
        arguments.setMark(Vector3.of(FastMath.floorToInt(xz.getX()),
                                     FastMath.floorToInt(
                                             y.evaluate(implementationArguments, scope).doubleValue()),
                                     FastMath.floorToInt(xz.getZ())).mutable().add(arguments.getOrigin()).immutable(),
                          mark.evaluate(implementationArguments, scope));
        return null;
    }
    
    @Override
    public SourcePosition getPosition() {
        return position;
    }
    
    @Override
    public ReturnType returnType() {
        return ReturnType.VOID;
    }
}
