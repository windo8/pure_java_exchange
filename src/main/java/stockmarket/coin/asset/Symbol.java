package stockmarket.coin.asset;

public enum Symbol {
    BTC("Bitcoin"),
    ETH("Ethereum"),
    XRP("Ripple");

    private final String displayName;

    Symbol(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}