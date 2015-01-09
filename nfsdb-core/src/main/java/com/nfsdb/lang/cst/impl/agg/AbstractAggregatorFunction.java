/*
 * Copyright (c) 2014. Vlad Ilyushchenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nfsdb.lang.cst.impl.agg;

import com.nfsdb.factory.configuration.ColumnMetadata;

public abstract class AbstractAggregatorFunction implements AggregatorFunction {

    private int map[];

    @Override
    public final ColumnMetadata[] getColumns() {
        ColumnMetadata[] m = getColumnsInternal();
        map = new int[m.length];
        return m;
    }

    @Override
    public final void mapColumn(int k, int i) {
        map[k] = i;
    }

    protected abstract ColumnMetadata[] getColumnsInternal();

    protected int map(int x) {
        return map[x];
    }
}
