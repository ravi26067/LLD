package lld.lms;

public class Member extends Account{

    int totalBooksCheckout;

    BookIssueService bookIssueService;

    @Override
    public boolean resetPassword() {
        return false;
    }

    public boolean checkoutBook(BookItem bookItem){
        if(totalBooksCheckout>Constants.MAX_BOOKS_ISSUED) {
            System.out.println("Book limit exceded");
            return false;
        }
        return true;
    }


}
