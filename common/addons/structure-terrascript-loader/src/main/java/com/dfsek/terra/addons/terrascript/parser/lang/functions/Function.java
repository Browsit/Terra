/*
 * Copyright (c) 2020-2021 Polyhedral Development
 *
 * The Terra Core Addons are licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in this module's root directory.
 */

package com.dfsek.terra.addons.terrascript.parser.lang.functions;

import java.util.Map;

import com.dfsek.terra.addons.terrascript.parser.lang.ImplementationArguments;
import com.dfsek.terra.addons.terrascript.parser.lang.Returnable;
import com.dfsek.terra.addons.terrascript.parser.lang.variables.Variable;
import com.dfsek.terra.addons.terrascript.tokenizer.Position;


public interface Function<T> extends Returnable<T> {
    Function<?> NULL = new Function<>() {
        @Override
        public ReturnType returnType() {
            return null;
        }
        
        @Override
        public Object apply(ImplementationArguments implementationArguments, Map<String, Variable<?>> variableMap) {
            return null;
        }
        
        @Override
        public Position getPosition() {
            return null;
        }
    };
}
