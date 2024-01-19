package librarymanagement.searcher;

import librarymanagement.user.Member;
import java.util.List;

public class IDBasedMemberSearcher implements MemberSearcher{

    private final int id;

    public IDBasedMemberSearcher(int id) {
        this.id = id;
    }

    @Override
    public List<Member> search() {
        return null;
    }
}
