/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 */
package org.lwjgl.opengl.templates

import org.lwjgl.generator.*
import org.lwjgl.generator.opengl.*
import org.lwjgl.opengl.*

val EXT_vertex_attrib_64bit = "EXTVertexAttrib64bit".nativeClassGL("EXT_vertex_attrib_64bit", postfix = EXT) {
	nativeImport (
		"OpenGL.h"
	)

	documentation =
		"""
		Native bindings to the $registryLink extension.

		This extension provides OpenGL shading language support for vertex shader inputs with 64-bit floating-point components and OpenGL API support for
		specifying the value of those inputs using vertex array or immediate mode entry points. This builds on the support for general-purpose support for
		64-bit floating-point values in the ARB_gpu_shader_fp64 extension.

		This extension provides a new class of vertex attribute functions, beginning with "VertexAttribL" ("L" for "long"), that can be used to specify
		attributes with 64-bit floating-point components. This extension provides no automatic type conversion between attribute and shader variables;
		single-precision attributes are not automatically converted to double-precision or vice versa. For shader variables with 64-bit component types, the
		"VertexAttribL" functions must be used to specify attribute values. For other shader variables, the "VertexAttribL" functions must not be used. If a
		vertex attribute is specified using the wrong attribute function, the values of the corresponding shader input are undefined. This approach requiring
		matching types is identical to that used for the "VertexAttribI" functions provided by OpenGL 3.0 and the EXT_gpu_shader4 extension.

		Additionally, some vertex shader inputs using the wider 64-bit components may count double against the implementation-dependent limit on the number of
		vertex shader attribute vectors. A 64-bit scalar or a two-component vector consumes only a single generic vertex attribute; three- and four-component
		"long" may count as two. This approach is similar to the one used in the current GL where matrix attributes consume multiple attributes.

		Note that 64-bit generic vertex attributes were nominally supported beginning with the introduction of vertex shaders in OpenGL 2.0. However, the
		OpenGL Shading Language at the time had no support for 64-bit data types, so any such values were automatically converted to 32-bit.

		Support for 64-bit floating-point vertex attributes in this extension can be combined with other extensions. In particular, this extension provides an
		entry point that can be used with EXT_direct_state_access to directly set state for any vertex array object. Also, the related
		NV_vertex_attrib_integer_64bit extension provides an entry point to specify bindless vertex attribute arrays with 64-bit components, integer or
		floating-point.

		Requires ${GL30.core} and ${ARB_gpu_shader_fp64.link} (or equivalent functionality).
		"""

	IntConstant(
		"Returned in the {@code type} parameter of GetActiveAttrib.",

		"DOUBLE_VEC2_EXT" _ 0x8FFC,
		"DOUBLE_VEC3_EXT" _ 0x8FFD,
		"DOUBLE_VEC4_EXT" _ 0x8FFE,
		"DOUBLE_MAT2_EXT" _ 0x8F46,
		"DOUBLE_MAT3_EXT" _ 0x8F47,
		"DOUBLE_MAT4_EXT" _ 0x8F48,
		"DOUBLE_MAT2x3_EXT" _ 0x8F49,
		"DOUBLE_MAT2x4_EXT" _ 0x8F4A,
		"DOUBLE_MAT3x2_EXT" _ 0x8F4B,
		"DOUBLE_MAT3x4_EXT" _ 0x8F4C,
		"DOUBLE_MAT4x2_EXT" _ 0x8F4D,
		"DOUBLE_MAT4x3_EXT" _ 0x8F4E
	)

	GLvoid(
		"VertexAttribL1dEXT",
		"",

		GLuint.IN("index", ""),
		GLdouble.IN("x", "")
	)

	GLvoid(
		"VertexAttribL2dEXT",
		"",

		GLuint.IN("index", ""),
		GLdouble.IN("x", ""),
		GLdouble.IN("y", "")
	)

	GLvoid(
		"VertexAttribL3dEXT",
		"",

		GLuint.IN("index", ""),
		GLdouble.IN("x", ""),
		GLdouble.IN("y", ""),
		GLdouble.IN("z", "")
	)

	GLvoid(
		"VertexAttribL4dEXT",
		"",

		GLuint.IN("index", ""),
		GLdouble.IN("x", ""),
		GLdouble.IN("y", ""),
		GLdouble.IN("z", ""),
		GLdouble.IN("w", "")
	)

	GLvoid(
		"VertexAttribL1dvEXT",
		"",

		GLuint.IN("index", ""),
		const _ GLdouble_p.IN("v", "")
	)

	GLvoid(
		"VertexAttribL2dvEXT",
		"",

		GLuint.IN("index", ""),
		const _ GLdouble_p.IN("v", "")
	)

	GLvoid(
		"VertexAttribL3dvEXT",
		"",

		GLuint.IN("index", ""),
		const _ GLdouble_p.IN("v", "")
	)

	GLvoid(
		"VertexAttribL4dvEXT",
		"",

		GLuint.IN("index", ""),
		const _ GLdouble_p.IN("v", "")
	)

	GLvoid(
		"VertexAttribLPointerEXT",
		"",

		GLuint.IN("index", ""),
		GLint.IN("size", ""),
		AutoType("pointer", BufferType.GL_DOUBLE) _ GLenum.IN("type", ""),
		GLsizei.IN("stride", ""),
		ARRAY_BUFFER _ const _ GLvoid_p.IN("pointer", "")
	)

	GLvoid(
		"GetVertexAttribLdvEXT",
		"",

		GLuint.IN("index", ""),
		GLenum.IN("pname", ""),
		GLdouble_p.OUT("params", "")
	)

	DependsOn("GL_EXT_direct_state_access") _ GLvoid(
		"VertexArrayVertexAttribLOffsetEXT",
		"",

		GLuint.IN("vaobj", ""),
		GLuint.IN("buffer", ""),
		GLuint.IN("index", ""),
		GLint.IN("size", ""),
		GLenum.IN("type", ""),
		GLsizei.IN("stride", ""),
		GLintptr.IN("offset", "")
	)
}