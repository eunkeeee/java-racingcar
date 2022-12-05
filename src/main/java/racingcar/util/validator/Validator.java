package racingcar.util.validator;

import java.util.regex.Pattern;
import racingcar.util.ExceptionMessage;

public abstract class Validator {


    abstract void validate(String input) throws IllegalArgumentException;



}