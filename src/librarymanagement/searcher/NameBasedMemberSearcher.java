package librarymanagement.searcher;


import librarymanagement.user.Member;

import java.util.List;

public class NameBasedMemberSearcher implements MemberSearcher{

    private final String memberName;

    public NameBasedMemberSearcher(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public List<Member> search() {
        return null;
    }
}
