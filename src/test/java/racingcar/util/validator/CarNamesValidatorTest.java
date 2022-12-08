package racingcar.util.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ExceptionMessage;

class CarNamesValidatorTest {

    private CarNamesValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CarNamesValidator();
    }

    @Nested
    class invalidInputTest {

        @DisplayName("2개 미만의 이름은 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"은기", "우테코"})
        void 이름_개수_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMBER_OF_CARS.getMessage());
        }

        @DisplayName("6글자 이상의 이름은 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"이거는일곱글자,    다른사람 ", "아주아주긴글자, 나도긴이름이다"})
        void 이름_길이_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }


    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"은기    ,      지훈      ,    우테코"})
        void 정상_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }

    }
}