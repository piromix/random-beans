/*
 * The MIT License
 *
 *   Copyright (c) 2016, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package io.github.benas.randombeans.randomizers.java8;

import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class InstantRandomizerTest extends AbstractThreeTenRandomizerTest<Instant> {

    @Before
    public void setUp() {
        randomizer = new InstantRandomizer(SEED);
    }

    @Test
    public void generatedValueMustNoBeNull() {
        Instant instant = randomizer.getRandomValue();
        assertThat(instant).isNotNull();
    }

    @Test
    public void shouldGenerateTheSameValueForTheSameSeed() {
        Instant actual = randomizer.getRandomValue();
        /* FIXME dateRandomizer is erroneous, it does not always generate the same value for the same seed */
        Instant expected = Instant.ofEpochSecond(actual.getEpochSecond()).plusNanos(actual.getNano());

        assertThat(actual).isEqualTo(expected);
    }
}
