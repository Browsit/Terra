/*
 * Copyright (c) 2020-2021 Polyhedral Development
 *
 * The Terra Core Addons are licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in this module's root directory.
 */

package com.dfsek.terra.addons.terrascript.parser.lang.operations.statements;

import com.dfsek.terra.addons.terrascript.parser.lang.ImplementationArguments;
import com.dfsek.terra.addons.terrascript.parser.lang.Expression;
import com.dfsek.terra.addons.terrascript.parser.lang.Scope;
import com.dfsek.terra.addons.terrascript.parser.lang.operations.BinaryOperation;
import com.dfsek.terra.addons.terrascript.tokenizer.SourcePosition;


public class LessThanStatement extends BinaryOperation<Number, Boolean> {
    public LessThanStatement(Expression<Number> left, Expression<Number> right, SourcePosition position) {
        super(left, right, position);
    }
    
    
    @Override
    public Boolean evaluate(ImplementationArguments implementationArguments, Scope scope) {
        return applyBoolean(implementationArguments, scope);
    }
    
    @Override
    public boolean applyBoolean(ImplementationArguments implementationArguments, Scope scope) {
        return left.applyDouble(implementationArguments, scope) < right.applyDouble(implementationArguments, scope);
    }

    @Override
    public Expression.ReturnType returnType() {
        return Expression.ReturnType.BOOLEAN;
    }
}
