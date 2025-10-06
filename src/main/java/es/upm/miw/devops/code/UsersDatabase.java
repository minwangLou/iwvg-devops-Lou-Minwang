package es.upm.miw.devops.code;

import java.util.List;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {

        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions2 = List.of(
                new Fraction(2, 1),
                new Fraction(-1, 5),
                new Fraction(2, 4),
                new Fraction(4, 3)
        );
        List<Fraction> fractions3 = List.of(
                new Fraction(1, 5),
                new Fraction(3, -6),
                new Fraction(1, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions4 = List.of(
                new Fraction(2, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions5 = List.of(
                new Fraction(0, 1),
                new Fraction(0, -2),
                new Fraction(0, 3)
        );

        List<Fraction> fractions6 = List.of(
                new Fraction(0, 0),
                new Fraction(1, 0),
                new Fraction(1, 1)
        );

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1),
                new User("2", "Ana", "Blanco", fractions2),
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );
    }


    public Fraction findFirstProperFractionByUserId(String id) {
        return this.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .filter(f -> f.getNumerator() < f.getDenominator()) // propia
                .findFirst()
                .orElse(null);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return this.findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(f -> f.getNumerator() * f.getDenominator() < 0)) // 所有分数都为负
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return this.findAll()
                .filter(user -> user.getFractions().stream().allMatch(Fraction::isProper))
                .map(User::getId);
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return this.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(0, 1), Fraction::add);
    }
}
