package stockmarket.coin.dto;

import stockmarket.coin.asset.Symbol;

import java.time.LocalDateTime;

public class WalletDTO {
    /*
    userId: 사용자 식별을 위한 고유한 식별자
    currency: 화폐 종류 (예: BTC, ETH 등)
    balance: 해당 화폐의 잔고
    lockedBalance: 거래에 잠긴 금액
    availableBalance: 사용 가능한 잔고
    depositAddress: 입금 주소
    withdrawalAddress: 출금 주소
    createdAt: 지갑 생성일시
    updatedAt: 지갑 정보가 업데이트된 일시
    */
    private Long userId;
    private Symbol currency;
    private double balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자, 게터, 세터 등 필요한 메서드들
    public WalletDTO(Long userId, Symbol currency, double balance, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.currency = currency;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Symbol getCurrency() {
        return currency;
    }

    public void setCurrency(Symbol currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "WalletDTO{" +
                "userId=" + userId +
                ", currency=" + currency +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
