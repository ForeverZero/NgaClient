import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.zhd.ngaclient.INgaClient;
import org.zhd.ngaclient.NgaClient;
import org.zhd.ngaclient.exception.NgaException;

import java.io.IOException;

@Slf4j
public class TestNgaClient {

    private final INgaClient ngaClient;

    public TestNgaClient() {
        String token = System.getenv("token");
        assert token != null && !token.isBlank();
        String uid = System.getenv("uid");
        assert uid != null && !uid.isBlank();
        ngaClient = new NgaClient(token, uid);
    }

    @Test
    public void testSubjectList() throws IOException, NgaException {
        var subjectList = ngaClient.subjectList(7, 1);
        subjectList.getResult().getData().forEach(subjectInfo -> log.info("{} - {} - {}", subjectInfo.getTid(), subjectInfo.getAuthor(), subjectInfo.getSubject()));
    }

    @Test
    public void testHomeCategory() throws IOException, NgaException {
        ngaClient.homeCategoryV2();
    }

    @Test
    public void testForumFavor2Get() throws IOException, NgaException {
        ngaClient.forumFavor2Get();
    }

    @Test
    public void testSubjectSearch() throws Exception {
        ngaClient.subjectSearch(null, "Steam", 0);
    }
}
