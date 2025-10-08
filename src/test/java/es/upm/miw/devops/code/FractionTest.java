package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertThat(fraction.getNumerator()).isEqualTo(1);
        assertThat(fraction.getDenominator()).isEqualTo(1);
    }

    @Test
    void testConstructorAndGetters() {
        Fraction fraction = new Fraction(3, 4);
        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(4);
    }

    @Test
    void testSetters() {
        Fraction fraction = new Fraction(1, 2);
        fraction.setNumerator(5);
        fraction.setDenominator(6);

        assertThat(fraction.getNumerator()).isEqualTo(5);
        assertThat(fraction.getDenominator()).isEqualTo(6);
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertThat(fraction.decimal()).isCloseTo(0.5, within(1e-5));

        Fraction fraction2 = new Fraction(3, 4);
        assertThat(fraction2.decimal()).isCloseTo(0.75, within(1e-5));
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(2, 5);
        assertThat(fraction.toString()).contains("numerator=2").contains("denominator=5");
    }

    @Test
    void testIsProper() {
        assertThat(new Fraction(1, 2).isProper()).isTrue();
        assertThat(new Fraction(3, 2).isProper()).isFalse();
    }

    @Test
    void testIsImproper() {
        assertThat(new Fraction(3, 2).isImproper()).isTrue();
        assertThat(new Fraction(1, 2).isImproper()).isFalse();
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 4);
        assertThat(f1.isEquivalent(f2)).isTrue();
        assertThat(f1.isEquivalent(f3)).isFalse();
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        assertThat(result.getNumerator()).isEqualTo(5);
        assertThat(result.getDenominator()).isEqualTo(6);
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.multiply(f2);
        assertThat(result.getNumerator()).isEqualTo(6);
        assertThat(result.getDenominator()).isEqualTo(12);
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.divide(f2);
        assertThat(result.getNumerator()).isEqualTo(8);
        assertThat(result.getDenominator()).isEqualTo(9);
    }
}
