package MarketPlaceHW;

public abstract class AbstractUser implements User {
    private String name;

    public AbstractUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
