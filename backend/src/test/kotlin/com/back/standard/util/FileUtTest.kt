package com.back.standard.util

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FileUtTest {
    @Test
    @DisplayName("파일을 생성하고 삭제할 수 있다.")
    fun t1() {
        Ut.file.touch("test.txt")
        Ut.file.delete("test.txt")
    }
}