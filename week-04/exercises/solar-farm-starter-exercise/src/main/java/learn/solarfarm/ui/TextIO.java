package learn.solarfarm.ui;

import learn.solarfarm.models.Material;

public interface TextIO {

    void println(Object value);

    void print(Object value);

    void printf(String format, Object... values);

    String readString(String prompt);

    String readRequiredString(String prompt);

    boolean readBoolean(String prompt);

    boolean readBooleanWhileAllowingEmpty(String prompt, boolean originalValue);

    int readInt(String prompt);

    int readInt(String prompt, int max);

    int readInt(String prompt, int min, int max);

    int readIntWhileAllowingEmpty(String prompt, int originalValue);

    int readIntWhileAllowingEmpty(String prompt, int max, int originalValue);

    int readIntWhileAllowingEmpty(String prompt, int min, int max, int originalValue);

    <T extends Enum<T>> T readEnum(String prompt, Class<T> tEnum);

    <T extends Enum<T>> T readEnumWhileAllowingEmpty(String prompt, Class<T> tEnum, Material originalValue);
}
