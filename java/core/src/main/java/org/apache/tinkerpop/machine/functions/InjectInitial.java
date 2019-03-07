/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.machine.functions;

import org.apache.tinkerpop.machine.traversers.Traverser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InjectInitial<C, A> extends GFunction<C> implements InitialFunction<C, A> {

    private final List<Traverser<C, A>> traversers;

    public InjectInitial(final C coefficient, final A... objects) {
        super(coefficient);
        this.traversers = new ArrayList<>();
        for (final A object : objects) {
            this.traversers.add(new Traverser<>(this.coefficient, object));
        }

    }

    @Override
    public Iterator<Traverser<C, A>> get() {
        return this.traversers.iterator();
    }

    @Override
    public String toString() {
        return "[" + this.coefficient + "]" + this.getClass().getSimpleName() + ":" + this.traversers;
    }
}
