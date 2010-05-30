/*
 * Copyright 2008-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.transform

/**
 * @author Paul King
 */
class IndexedPropertyTransformTest extends GroovyShellTestCase {

    void testStandardCase() {
        assertScript """
            class Demo {
                @IndexedProperty List<Integer> foo
                @IndexedProperty String[] bar
                @IndexedProperty List baz
            }

            def d = new Demo()
            d.foo = [11, 22, 33]
            d.setFoo(0, 100)
            d.setFoo(1, 200)
            assert d.foo == [100, 200, 33]
            assert d.getFoo(1) == 200
            d.bar = ['cat']
            d.setBar(0, 'dog')
            assert d.getBar(0) == 'dog'
            d.baz = ['cat']
            d.setBaz(0, 'dog')
            assert d.getBaz(0) == 'dog'
        """
    }

}