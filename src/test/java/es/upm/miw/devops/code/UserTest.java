package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    void testConstructorAndGetters() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        User user = new User("1", "Min", "Wang", fractions);

        assertThat(user.getId()).isEqualTo("1");
        assertThat(user.getName()).isEqualTo("Min");
        assertThat(user.getFamilyName()).isEqualTo("Wang");
        assertThat(user.getFractions()).hasSize(1);
    }

    @Test
    void testSetters() {
        User user = new User();
        user.setName("Alice");
        user.setFamilyName("Smith");

        assertThat(user.getName()).isEqualTo("Alice");
        assertThat(user.getFamilyName()).isEqualTo("Smith");
    }

    @Test
    void testAddFraction() {
        User user = new User();
        Fraction fraction = new Fraction(3, 4);
        user.addFraction(fraction);

        assertThat(user.getFractions()).containsExactly(fraction);
    }

    @Test
    void testFullName() {
        User user = new User("2", "Bob", "Brown", new ArrayList<>());
        assertThat(user.fullName()).isEqualTo("Bob Brown");
    }

    @Test
    void testInitials() {
        User user = new User("3", "Charlie", "Doe", new ArrayList<>());
        assertThat(user.initials()).isEqualTo("C.");
    }

    @Test
    void testToStringContainsFields() {
        User user = new User("4", "David", "White", new ArrayList<>());
        String str = user.toString();

        assertThat(str).contains("id='4'");
        assertThat(str).contains("name='David'");
        assertThat(str).contains("familyName='White'");
    }

    @Test
    void testEmptyConstructor() {
        User user = new User();
        assertThat(user.getFractions()).isEmpty();
    }
}
