package JetBrains;

class AccountServiceImpl implements AccountService {
    Account[] accounts;

    AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts.clone();
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        for (Account account : accounts) {
            long ownerId = account.getOwner().getId();
            if (ownerId == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long balance) {
        long count = 0;
        for (Account account : accounts) {
            if (account.getBalance() > balance) {
                count++;
            }
        }
        return count;
    }
}
