package com.lunastratos.mudspoon.Config

import com.fasterxml.jackson.core.SerializableString
import com.fasterxml.jackson.core.io.CharacterEscapes
import com.fasterxml.jackson.core.io.SerializedString
import org.apache.commons.text.StringEscapeUtils


/**
 * HTMLCharacterEscapesConfig
 * desc: CharacterEscapes - Xss 방어 코드
 *
 * History:
 *    LunaStratos, 1.0, 2022-02-22 초기작성
 *
 * @date        2022-02-22
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
class HTMLCharacterEscapesConfig : CharacterEscapes() {
    private val asciiEscapes: IntArray

    init {

        // XSS 방지 처리할 특수 문자 지정
        asciiEscapes = standardAsciiEscapesForJSON()
        asciiEscapes['<'.code] = ESCAPE_CUSTOM
        asciiEscapes['>'.code] = ESCAPE_CUSTOM
        asciiEscapes['&'.code] = ESCAPE_CUSTOM
        asciiEscapes['\"'.code] = ESCAPE_CUSTOM
        asciiEscapes['('.code] = ESCAPE_CUSTOM
        asciiEscapes[')'.code] = ESCAPE_CUSTOM
        asciiEscapes['#'.code] = ESCAPE_CUSTOM
        asciiEscapes['\''.code] = ESCAPE_CUSTOM
    }

    override fun getEscapeCodesForAscii(): IntArray {
        return asciiEscapes
    }

    override fun getEscapeSequence(ch: Int): SerializableString? {
        val serializedString: SerializedString
        val charAt = ch.toChar()
        serializedString = if (Character.isHighSurrogate(charAt) || Character.isLowSurrogate(charAt)) {
            val sb = StringBuilder()
            sb.append("\\u")
            sb.append(String.format("%04x", ch))
            SerializedString(sb.toString())
        } else {
            SerializedString(StringEscapeUtils.escapeHtml4(Character.toString(charAt)))
        }
        return serializedString
    }
}