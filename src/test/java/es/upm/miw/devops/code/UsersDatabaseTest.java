package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersDatabaseTest {

    private UsersDatabase db;

    @BeforeEach
    void setUp() {
        db = new UsersDatabase();
    }

    @Test
    void testFindFirstProperFractionByUserId() {

        Fraction result = db.findFirstProperFractionByUserId("2");

        assertThat(result).isNotNull();
        assertThat(result.getNumerator()).isEqualTo(-1);
        assertThat(result.getDenominator()).isEqualTo(5);
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {

        assertThat(db.findUserFamilyNameByAllNegativeSignFractionDistinct().toList())
                .isEmpty();
    }

    @Test
    void testFindUserIdByAllProperFraction() {

        assertThat(db.findUserIdByAllProperFraction().toList())
                .containsExactly("5");
    }

    @Test
    void testFindFractionAdditionByUserId() {
        UsersDatabase db = new UsersDatabase();

        Fraction result = db.findFractionAdditionByUserId("2");

        assertThat(result.getNumerator()).isEqualTo(218);
        assertThat(result.getDenominator()).isEqualTo(60);
    }

}