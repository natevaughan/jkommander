package com.natevaughan.jkommander

import org.junit.Test
import org.junit.Assert.*

/**
 * Created by nate on 9/19/17
 */
class ArgsTest {
    @Test
    fun testLoadProperties() {

        val props = App.parse(arrayOf("-f", "foo.properties", "-d"))

        assertNotNull(props.file)
        assertEquals(props.file, "foo.properties")
        assertNotNull(props.debug)
        assertEquals(props.debug, true)
    }

}