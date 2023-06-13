package kr.eddi.demo.RefactorAccount.repository;

public interface UserTokenRepository {

    void save(String userToken, Long id);

    Long findRoleByToken(String userToken);
}
