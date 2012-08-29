/**
 * Copyright (c) 2009-2012, Lukas Eder, lukas.eder@gmail.com
 * All rights reserved.
 *
 * This software is licensed to you under the Apache License, Version 2.0
 * (the "License"); You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * . Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * . Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * . Neither the name "jOOQ" nor the names of its contributors may be
 *   used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jooq.impl;

import static java.util.Arrays.asList;
import static org.jooq.Comparator.NOT_EQUALS;
import static org.jooq.SQLDialect.DB2;
import static org.jooq.SQLDialect.ORACLE;
import static org.jooq.impl.Factory.tuple;

import java.util.Arrays;
import java.util.Collection;

import org.jooq.BindContext;
import org.jooq.Comparator;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.QueryPart;
import org.jooq.RenderContext;
import org.jooq.Select;
import org.jooq.Tuple1;
import org.jooq.Tuple2;
import org.jooq.Tuple3;
import org.jooq.Tuple4;
import org.jooq.Tuple5;
import org.jooq.Tuple6;
import org.jooq.Tuple7;
import org.jooq.Tuple8;
import org.jooq.TupleN;
import org.jooq.exception.DataAccessException;

/**
 * @author Lukas Eder
 */
class TupleImpl<T1, T2, T3, T4, T5, T6, T7, T8> extends AbstractNamedQueryPart
implements

    // This tuple implementation implements all tuple types. Type-safety is
    // being checked through the type-safe API. No need for further checks here
    Tuple1<T1>,
    Tuple2<T1, T2>,
    Tuple3<T1, T2, T3>,
    Tuple4<T1, T2, T3, T4>,
    Tuple5<T1, T2, T3, T4, T5>,
    Tuple6<T1, T2, T3, T4, T5, T6>,
    Tuple7<T1, T2, T3, T4, T5, T6, T7>,
    Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>,
    TupleN {

    /**
     * Generated UID
     */
    private static final long serialVersionUID = -929427349071556318L;

    private final Field<?>[]  fields;

    TupleImpl(Field<?>... fields) {
        super("tuple");

        this.fields = fields;
    }

    // ------------------------------------------------------------------------
    // XXX: QueryPart API
    // ------------------------------------------------------------------------

    @Override
    public final void toSQL(RenderContext context) {
        context.sql("(");

        String separator = "";
        for (Field<?> field : fields) {
            context.sql(separator);
            context.sql(field);

            separator = ", ";
        }

        context.sql(")");
    }

    @Override
    public final void bind(BindContext context) {
        context.bind(fields);
    }

    // ------------------------------------------------------------------------
    // XXX: Tuple API
    // ------------------------------------------------------------------------

    @Override
    public final Condition equal(Tuple1<T1> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(Tuple2<T1, T2> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(Tuple3<T1, T2, T3> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(Tuple4<T1, T2, T3, T4> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(Tuple5<T1, T2, T3, T4, T5> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(Tuple6<T1, T2, T3, T4, T5, T6> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(Tuple7<T1, T2, T3, T4, T5, T6, T7> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(TupleN tuple) {
        return new TupleCompareCondition(tuple, Comparator.EQUALS);
    }

    @Override
    public final Condition equal(T1 t1) {
        return equal(tuple(t1));
    }

    @Override
    public final Condition equal(T1 t1, T2 t2) {
        return equal(tuple(t1, t2));
    }

    @Override
    public final Condition equal(T1 t1, T2 t2, T3 t3) {
        return equal(tuple(t1, t2, t3));
    }

    @Override
    public final Condition equal(T1 t1, T2 t2, T3 t3, T4 t4) {
        return equal(tuple(t1, t2, t3, t4));
    }

    @Override
    public final Condition equal(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return equal(tuple(t1, t2, t3, t4, t5));
    }

    @Override
    public final Condition equal(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return equal(tuple(t1, t2, t3, t4, t5, t6));
    }

    @Override
    public final Condition equal(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return equal(tuple(t1, t2, t3, t4, t5, t6, t7));
    }

    @Override
    public final Condition equal(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return equal(tuple(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    @Override
    public final Condition equal(Object... values) {
        return equal(tuple(values));
    }

    @Override
    public final Condition equal(Field<T1> t1) {
        return equal(tuple(t1));
    }

    @Override
    public final Condition equal(Field<T1> t1, Field<T2> t2) {
        return equal(tuple(t1, t2));
    }

    @Override
    public final Condition equal(Field<T1> t1, Field<T2> t2, Field<T3> t3) {
        return equal(tuple(t1, t2, t3));
    }

    @Override
    public final Condition equal(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4) {
        return equal(tuple(t1, t2, t3, t4));
    }

    @Override
    public final Condition equal(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5) {
        return equal(tuple(t1, t2, t3, t4, t5));
    }

    @Override
    public final Condition equal(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6) {
        return equal(tuple(t1, t2, t3, t4, t5, t6));
    }

    @Override
    public final Condition equal(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7) {
        return equal(tuple(t1, t2, t3, t4, t5, t6, t7));
    }

    @Override
    public final Condition equal(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7, Field<T8> t8) {
        return equal(tuple(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    @Override
    public final Condition equal(Field<?>... f) {
        return equal(tuple(f));
    }

    @Override
    public final Condition eq(Tuple1<T1> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(Tuple2<T1, T2> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(Tuple3<T1, T2, T3> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(Tuple4<T1, T2, T3, T4> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(Tuple5<T1, T2, T3, T4, T5> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(Tuple6<T1, T2, T3, T4, T5, T6> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(Tuple7<T1, T2, T3, T4, T5, T6, T7> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(TupleN tuple) {
        return equal(tuple);
    }

    @Override
    public final Condition eq(T1 t1) {
        return equal(t1);
    }

    @Override
    public final Condition eq(T1 t1, T2 t2) {
        return equal(t1, t2);
    }

    @Override
    public final Condition eq(T1 t1, T2 t2, T3 t3) {
        return equal(t1, t2, t3);
    }

    @Override
    public final Condition eq(T1 t1, T2 t2, T3 t3, T4 t4) {
        return equal(t1, t2, t3, t4);
    }

    @Override
    public final Condition eq(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return equal(t1, t2, t3, t4, t5);
    }

    @Override
    public final Condition eq(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return equal(t1, t2, t3, t4, t5, t6);
    }

    @Override
    public final Condition eq(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return equal(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    public final Condition eq(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return equal(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    public final Condition eq(Object... values) {
        return equal(values);
    }

    @Override
    public final Condition eq(Field<T1> t1) {
        return equal(t1);
    }

    @Override
    public final Condition eq(Field<T1> t1, Field<T2> t2) {
        return equal(t1, t2);
    }

    @Override
    public final Condition eq(Field<T1> t1, Field<T2> t2, Field<T3> t3) {
        return equal(t1, t2, t3);
    }

    @Override
    public final Condition eq(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4) {
        return equal(t1, t2, t3, t4);
    }

    @Override
    public final Condition eq(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5) {
        return equal(t1, t2, t3, t4, t5);
    }

    @Override
    public final Condition eq(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6) {
        return equal(t1, t2, t3, t4, t5, t6);
    }

    @Override
    public final Condition eq(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7) {
        return equal(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    public final Condition eq(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7, Field<T8> t8) {
        return equal(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    public final Condition eq(Field<?>... values) {
        return equal(values);
    }

    @Override
    public final Condition notEqual(Tuple1<T1> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(Tuple2<T1, T2> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(Tuple3<T1, T2, T3> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(Tuple4<T1, T2, T3, T4> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(Tuple5<T1, T2, T3, T4, T5> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(Tuple6<T1, T2, T3, T4, T5, T6> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(Tuple7<T1, T2, T3, T4, T5, T6, T7> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(TupleN tuple) {
        return new TupleCompareCondition(tuple, Comparator.NOT_EQUALS);
    }

    @Override
    public final Condition notEqual(T1 t1) {
        return notEqual(tuple(t1));
    }

    @Override
    public final Condition notEqual(T1 t1, T2 t2) {
        return notEqual(tuple(t1, t2));
    }

    @Override
    public final Condition notEqual(T1 t1, T2 t2, T3 t3) {
        return notEqual(tuple(t1, t2, t3));
    }

    @Override
    public final Condition notEqual(T1 t1, T2 t2, T3 t3, T4 t4) {
        return notEqual(tuple(t1, t2, t3, t4));
    }

    @Override
    public final Condition notEqual(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return notEqual(tuple(t1, t2, t3, t4, t5));
    }

    @Override
    public final Condition notEqual(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return notEqual(tuple(t1, t2, t3, t4, t5, t6));
    }

    @Override
    public final Condition notEqual(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return notEqual(tuple(t1, t2, t3, t4, t5, t6, t7));
    }

    @Override
    public final Condition notEqual(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return notEqual(tuple(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    @Override
    public final Condition notEqual(Object... values) {
        return notEqual(tuple(values));
    }

    @Override
    public final Condition notEqual(Field<T1> t1) {
        return notEqual(tuple(t1));
    }

    @Override
    public final Condition notEqual(Field<T1> t1, Field<T2> t2) {
        return notEqual(tuple(t1, t2));
    }

    @Override
    public final Condition notEqual(Field<T1> t1, Field<T2> t2, Field<T3> t3) {
        return notEqual(tuple(t1, t2, t3));
    }

    @Override
    public final Condition notEqual(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4) {
        return notEqual(tuple(t1, t2, t3, t4));
    }

    @Override
    public final Condition notEqual(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5) {
        return notEqual(tuple(t1, t2, t3, t4, t5));
    }

    @Override
    public final Condition notEqual(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6) {
        return notEqual(tuple(t1, t2, t3, t4, t5, t6));
    }

    @Override
    public final Condition notEqual(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7) {
        return notEqual(tuple(t1, t2, t3, t4, t5, t6, t7));
    }

    @Override
    public final Condition notEqual(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7, Field<T8> t8) {
        return notEqual(tuple(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    @Override
    public final Condition notEqual(Field<?>... f) {
        return notEqual(tuple(f));
    }

    @Override
    public final Condition ne(Tuple1<T1> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(Tuple2<T1, T2> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(Tuple3<T1, T2, T3> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(Tuple4<T1, T2, T3, T4> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(Tuple5<T1, T2, T3, T4, T5> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(Tuple6<T1, T2, T3, T4, T5, T6> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(Tuple7<T1, T2, T3, T4, T5, T6, T7> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(TupleN tuple) {
        return notEqual(tuple);
    }

    @Override
    public final Condition ne(T1 t1) {
        return notEqual(t1);
    }

    @Override
    public final Condition ne(T1 t1, T2 t2) {
        return notEqual(t1, t2);
    }

    @Override
    public final Condition ne(T1 t1, T2 t2, T3 t3) {
        return notEqual(t1, t2, t3);
    }

    @Override
    public final Condition ne(T1 t1, T2 t2, T3 t3, T4 t4) {
        return notEqual(t1, t2, t3, t4);
    }

    @Override
    public final Condition ne(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return notEqual(t1, t2, t3, t4, t5);
    }

    @Override
    public final Condition ne(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return notEqual(t1, t2, t3, t4, t5, t6);
    }

    @Override
    public final Condition ne(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return notEqual(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    public final Condition ne(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return notEqual(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    public final Condition ne(Object... values) {
        return notEqual(values);
    }

    @Override
    public final Condition ne(Field<T1> t1) {
        return notEqual(t1);
    }

    @Override
    public final Condition ne(Field<T1> t1, Field<T2> t2) {
        return notEqual(t1, t2);
    }

    @Override
    public final Condition ne(Field<T1> t1, Field<T2> t2, Field<T3> t3) {
        return notEqual(t1, t2, t3);
    }

    @Override
    public final Condition ne(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4) {
        return notEqual(t1, t2, t3, t4);
    }

    @Override
    public final Condition ne(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5) {
        return notEqual(t1, t2, t3, t4, t5);
    }

    @Override
    public final Condition ne(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6) {
        return notEqual(t1, t2, t3, t4, t5, t6);
    }

    @Override
    public final Condition ne(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7) {
        return notEqual(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    public final Condition ne(Field<T1> t1, Field<T2> t2, Field<T3> t3, Field<T4> t4, Field<T5> t5, Field<T6> t6, Field<T7> t7, Field<T8> t8) {
        return notEqual(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    public final Condition ne(Field<?>... values) {
        return notEqual(values);
    }

    @Override
    public final Condition in(Tuple1<T1>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(Tuple2<T1, T2>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(Tuple3<T1, T2, T3>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(Tuple4<T1, T2, T3, T4>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(Tuple5<T1, T2, T3, T4, T5>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(Tuple6<T1, T2, T3, T4, T5, T6>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(Tuple7<T1, T2, T3, T4, T5, T6, T7>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition in(TupleN... tuples) {
        return in(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple1<T1>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple2<T1, T2>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple3<T1, T2, T3>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple4<T1, T2, T3, T4>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple5<T1, T2, T3, T4, T5>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple6<T1, T2, T3, T4, T5, T6>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple7<T1, T2, T3, T4, T5, T6, T7>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @Override
    public final Condition notIn(TupleN... tuples) {
        return notIn(Arrays.asList(tuples));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final Condition in(Collection tuples) {
        QueryPartList<QueryPart> list = new QueryPartList<QueryPart>(tuples);
        return new TupleInCondition(list, InOperator.IN);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final Condition notIn(Collection tuples) {
        QueryPartList<QueryPart> list = new QueryPartList<QueryPart>(tuples);
        return new TupleInCondition(list, InOperator.NOT_IN);
    }

    @Override
    public final Condition in(Select<?> select) {
        return new TupleInCondition(select, InOperator.IN);
    }

    @Override
    public final Condition notIn(Select<?> select) {
        return new TupleInCondition(select, InOperator.NOT_IN);
    }

    // ------------------------------------------------------------------------
    // XXX: Implementation classes
    // ------------------------------------------------------------------------

    private class TupleCompareCondition extends AbstractCondition {

        /**
         * Generated UID
         */
        private static final long serialVersionUID = -1806139685201770706L;

        private final QueryPart   other;
        private final Comparator  comparator;

        TupleCompareCondition(QueryPart other, Comparator comparator) {
            this.other = other;
            this.comparator = comparator;
        }

        @Override
        public final void toSQL(RenderContext context) {

            // Some dialects do not support != comparison with tuples
            if (comparator == NOT_EQUALS && asList(DB2).contains(context.getDialect())) {
                context.keyword("not(")
                       .sql(TupleImpl.this)
                       .sql(" = ")
                       .sql(other)
                       .sql(")");
            }
            else {
                // Some databases need extra parentheses around the RHS
                boolean extraParentheses = asList(ORACLE).contains(context.getDialect());

                context.sql(TupleImpl.this)
                       .sql(" ")
                       .sql(comparator.toSQL())
                       .sql(" ")
                       .sql(extraParentheses ? "(" : "")
                       .sql(other)
                       .sql(extraParentheses ? ")" : "");
            }
        }

        @Override
        public final void bind(BindContext context) throws DataAccessException {
            context.bind(TupleImpl.this).bind(other);
        }
    }

    private class TupleInCondition extends AbstractCondition {

        /**
         * Generated UID
         */
        private static final long serialVersionUID = -1806139685201770706L;

        private final QueryPart   other;
        private final InOperator  operator;

        TupleInCondition(QueryPart other, InOperator operator) {
            this.other = other;
            this.operator = operator;
        }

        @Override
        public final void toSQL(RenderContext context) {

            // Some databases need extra parentheses around the RHS
            boolean extraParentheses =
                other instanceof Select<?> && asList(ORACLE).contains(context.getDialect());
            boolean subquery = context.subquery();

            context.sql(TupleImpl.this)
                   .sql(" ")
                   .keyword(operator.toSQL())
                   .sql(" (")
                   .sql(extraParentheses ? "(" : "")
                   .subquery(true)
                   .sql(other)
                   .subquery(subquery)
                   .sql(extraParentheses ? ")" : "")
                   .sql(")");
        }

        @Override
        public final void bind(BindContext context) throws DataAccessException {
            context.bind(TupleImpl.this).bind(other);
        }
    }
}
