import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

public class SafeEnumSetBitmaskConverter {

  public static <E extends Enum<E> & BitflagGetable> int enumsetToBitmask(EnumSet<E> enumSet) {
    return enumSet.stream()
        .mapToInt(BitflagGetable::getBitflag)
        .reduce(0, (i, j) -> i | j);
  }

  public static <E extends Enum<E> & BitflagGetable> EnumSet<E> bitmaskToEnumSet(Class<E> elementType, int bitmask) {
    return Arrays.stream(elementType.getEnumConstants())
        .filter(e -> (e.getBitflag() & bitmask) != 0)
        .collect(Collectors.toCollection(() -> EnumSet.noneOf(elementType)));
  }

  private SafeEnumSetBitmaskConverter() {
    throw new AssertionError();
  }
}