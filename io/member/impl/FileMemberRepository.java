package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-txt.dat";
    private static final String DELIMETER = ",";

    @Override
    public void add(Member member) {
        FileWriter fw = new FileWriter(FILE_PATH, UTF_8, true);
        BufferedWriter bw = new BufferedWriter(fw);
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
