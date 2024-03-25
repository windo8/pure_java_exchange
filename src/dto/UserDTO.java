package dto;

import java.util.List;

public class UserDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private List<WalletDTO> wallets;

    public UserDTO(Long userId, String userName, String userEmail, String userPassword, List<WalletDTO> wallets) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.wallets = wallets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<WalletDTO> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletDTO> wallets) {
        this.wallets = wallets;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
