package r.javahelp;

public class TicTacToken {
    private static String taken = "";
    public final String tokenChatacter;

    private TicTacToken(char tokenCharacter) {
        this.tokenChatacter = String.valueOf(tokenCharacter).toUpperCase();
        if (TicTacToken.taken.contains(this.tokenChatacter)) {
            throw new IllegalArgumentException(String.format("Value %s is in use.",
                    this.tokenChatacter));
        } else {
            TicTacToken.taken += this.tokenChatacter;
        }
    }

    public static TicTacToken getToken(char tokenCharacter) {
        return new TicTacToken(tokenCharacter);
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        return this.tokenChatacter.equalsIgnoreCase(o.toString());
    }

    @Override
    public int hashCode() {
        return this.tokenChatacter.hashCode();
    }

    @Override
    public String toString() {
        return this.tokenChatacter;
    }

    public static void main(String args[]) {
        TicTacToken test = TicTacToken.getToken('x');
        System.out.println(test);
        test = TicTacToken.getToken('o');
        System.out.println(test);
        test = TicTacToken.getToken('x');
    }
}
