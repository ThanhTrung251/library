package com.hivetech.lib.service;

import com.hivetech.lib.model.dto.MemberDTO;
import com.hivetech.lib.model.entity.Member;
import com.hivetech.lib.model.request.MemberRequest;

import java.util.List;

public interface MemberService {
    List<MemberDTO> getAllMember();
    MemberDTO creatMember(MemberRequest memberRequest) ;
    MemberDTO updateMember(Long id,MemberRequest memberRequest);
    void deleteMember(long id);
    MemberDTO getMemberById(Long id);

    List<MemberDTO> searchMember(String keyword);
}
