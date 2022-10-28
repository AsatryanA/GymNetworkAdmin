package com.example.gym.service;

import com.example.gym.dto.InitWallet;
import com.example.gym.model.Wallet;
import com.example.gym.repository.WalletsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class WalletsService {
    private final WalletsRepository walletsRepository;


    public boolean verification(String verificationCode) {
        Wallet byVerifiedCode = walletsRepository.findByVerifiedCode(verificationCode);
        if (byVerifiedCode != null) {
            byVerifiedCode.setVerified(true);
            byVerifiedCode.setVerifiedCode("0");
            byVerifiedCode.setVerificationDate(new Date(System.currentTimeMillis()));
            walletsRepository.save(byVerifiedCode);
            return true;
        }
        return false;
    }

    public Wallet register(InitWallet initWallet) {
        Wallet wallet = new Wallet();
        wallet.setAddress(initWallet.getAddress());
        wallet.setReferralAddress(initWallet.getReferralAddress());
        wallet.setReferralId(initWallet.getReferralId());
        wallet.setVerifiedCode(getRandomNumberString());
        wallet.setVerified(false);
        wallet.setWithdrawals(false);
        walletsRepository.save(wallet);
        return wallet;
    }

    private static String getRandomNumberString() {
        return RandomStringUtils.random(13, "0123456789abcdef");
    }
}
