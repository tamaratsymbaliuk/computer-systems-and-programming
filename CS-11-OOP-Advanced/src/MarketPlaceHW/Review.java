package MarketPlaceHW;

public class Review {
    private Buyer buyer;
    private Seller seller;
    private String comment;
    private int rating;

    public Review(Buyer buyer, Seller seller, String comment, int rating) {
        this.buyer = buyer;
        this.seller = seller;
        this.comment = comment;
        this.rating = rating;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
    @Override
    public String toString() {
        return "Review(buyer: " + buyer.getName() + ", rating: " + rating + ", comment: " + comment + ")";
    }
}
