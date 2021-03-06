/*
 *	Copyright 2022 cufy.org
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package org.cufy.kaguya

import graphql.schema.DataFetchingEnvironment

/**
 * The type of the resolver scope.
 *
 * @since 1.0.0
 */
typealias ResolverScope = DataFetchingEnvironment

/**
 * The main class of this library.
 * Currently, has no purpose.
 *
 * @author LSafer
 * @since 1.0.0
 */
open class Kaguya {
    companion object : Kaguya()
}
