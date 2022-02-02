@file:Suppress("unused", "KDocUnresolvedReference")

package cn.bugsnet.clikt.localization

import com.github.ajalt.clikt.output.*

open class CliktChineseLocalization: Localization {
    /** [Abort] was thrown */
    override fun aborted() = "被中断!"

    /** Prefix for any [UsageError] */
    override fun usageError(message: String) = "错误: $message"

    /** Message for [BadParameterValue] */
    override fun badParameter() = "非法值"

    /** Message for [BadParameterValue] */
    override fun badParameterWithMessage(message: String) = "非法值: $message"

    /** Message for [BadParameterValue] */
    override fun badParameterWithParam(paramName: String) = "\"$paramName\"的参数值非法"

    /** Message for [BadParameterValue] */
    override fun badParameterWithMessageAndParam(paramName: String, message: String) =
        "\"$paramName\"的参数值非法: $message"

    /** Message for [MissingOption] */
    override fun missingOption(paramName: String) = "缺少选项\"$paramName\""

    /** Message for [MissingArgument] */
    override fun missingArgument(paramName: String) = "缺少参数\"$paramName\""

    /** Message for [NoSuchSubcommand] */
    override fun noSuchSubcommand(name: String, possibilities: List<String>): String {
        return "没有此命令: \"$name\"" + when (possibilities.size) {
            0 -> ""
            1 -> "。 你是想输入\"${possibilities[0]}\"吗?"
            else -> possibilities.joinToString(prefix = "。 (相似的子命令: ", postfix = ")")
        }
    }

    /** Message for [NoSuchOption] */
    override fun noSuchOption(name: String, possibilities: List<String>): String {
        return "没有此选项: \"$name\"" + when (possibilities.size) {
            0 -> ""
            1 -> "。 你是想输入\"${possibilities[0]}\"吗?"
            else -> possibilities.joinToString(prefix = ". (相似的选项: ", postfix = ")")
        }
    }

    /**
     * Message for [IncorrectOptionValueCount]
     *
     * @param count non-negative count of required values
     */
    override fun incorrectOptionValueCount(name: String, count: Int): String {
        return when (count) {
            0 -> "选项 $name 不接受值"
            1 -> "选项 $name 需要一个值"
            else -> "选项 $name 需要${count}个值"
        }
    }

    /**
     * Message for [IncorrectArgumentValueCount]
     *
     * @param count non-negative count of required values
     */
    override fun incorrectArgumentValueCount(name: String, count: Int): String {
        return when (count) {
            0 -> "参数 $name 不接受值"
            1 -> "参数 $name 需要一个值"
            else -> "参数 $name 需要${count}个值"
        }
    }

    /**
     * Message for [MutuallyExclusiveGroupException]
     *
     * @param others non-empty list of other options in the group
     */
    override fun mutexGroupException(name: String, others: List<String>): String {
        return "选项 $name 不能与 ${others.joinToString(" 或 ")} 同时使用"
    }

    /** Message for [FileNotFound] */
    override fun fileNotFound(filename: String) = "文件 $filename 未找到"

    /** Message for [InvalidFileFormat]*/
    override fun invalidFileFormat(filename: String, message: String) =
        "文件 $filename 格式错误: $message"

    /** Message for [InvalidFileFormat]*/
    override fun invalidFileFormat(filename: String, lineNumber: Int, message: String) =
        "文件 $filename 的第 $lineNumber 行格式错误: $message"

    /** Error in message for [InvalidFileFormat] */
    override fun unclosedQuote() = "引号未闭合"

    /** Error in message for [InvalidFileFormat] */
    override fun fileEndsWithSlash() = """文件以"\"结尾"""

    /** One extra argument is present */
    override fun extraArgumentOne(name: String) = "多余的参数： $name"

    /** More than one extra argument is present */
    override fun extraArgumentMany(name: String, count: Int) = "多余的${count}个参数： $name"

    /** Error message when reading flag option from a file */
    override fun invalidFlagValueInFile(name: String) = "不支持从文件中读取标识选项 $name"

    /** Error message when reading switch option from environment variable */
    override fun switchOptionEnvvar() = "不支持从环境变量中读取开关选项"

    /** Required [MutuallyExclusiveOptions] was not provided */
    override fun requiredMutexOption(options: String) = "必须在 $options 中选择一个"

    /**
     * [ChoiceGroup] value was invalid
     *
     * @param choices non-empty list of possible choices
     */
    override fun invalidGroupChoice(value: String, choices: List<String>): String {
        return "非法选项: $value。 (可选项： ${choices.joinToString()})"
    }

    /** Invalid value for a parameter of type [Double] or [Float] */
    override fun floatConversionError(value: String) = "$value 不是合法的浮点数。"

    /** Invalid value for a parameter of type [Int] or [Long] */
    override fun intConversionError(value: String) = "$value 不是合法的整数。"

    /** Invalid value for a parameter of type [Boolean] */
    override fun boolConversionError(value: String) = "$value 不是合法的布尔值。"

    /** Invalid value falls outside range */
    override fun rangeExceededMax(value: String, limit: String) =
        "$value 比最大值 $limit 更大。"

    /** Invalid value falls outside range */
    override fun rangeExceededMin(value: String, limit: String) =
        "$value 比最小值 $limit 更小。"

    /** Invalid value falls outside range */
    override fun rangeExceededBoth(value: String, min: String, max: String) =
        "$value 不在合法范围 $min 到 $max 之间。"

    /**
     * Invalid value for `choice` parameter
     *
     * @param choices non-empty list of possible choices
     */
    override fun invalidChoice(choice: String, choices: List<String>): String {
        return "非法选项: $choice (可选项： ${choices.joinToString()})"
    }

    /** The `pathType` parameter to [pathDoesNotExist] and other `path*` errors */
    override fun pathTypeFile() = "文件"

    /** The `pathType` parameter to [pathDoesNotExist] and other `path*` errors */
    override fun pathTypeDirectory() = "文件夹"

    /** The `pathType` parameter to [pathDoesNotExist] and other `path*` errors */
    override fun pathTypeOther() = "文件或目录"

    /** Invalid path type */
    override fun pathDoesNotExist(pathType: String, path: String) = "$pathType \"$path\" 不存在。"

    /** Invalid path type */
    override fun pathIsFile(pathType: String, path: String) = "$pathType \"$path\" 是文件。"

    /** Invalid path type */
    override fun pathIsDirectory(pathType: String, path: String) = "$pathType \"$path\" 是文件夹。"

    /** Invalid path type */
    override fun pathIsNotWritable(pathType: String, path: String) = "$pathType \"$path\" 不可写。"

    /** Invalid path type */
    override fun pathIsNotReadable(pathType: String, path: String) = "$pathType \"$path\" 不可读。"

    /** Invalid path type */
    override fun pathIsSymlink(pathType: String, path: String) = "$pathType \"$path\" 是符号链。."

    /** Metavar used for options with unspecified value type */
    override fun defaultMetavar() = "值"

    /** Metavar used for options that take [String] values */
    override fun stringMetavar() = "文本"

    /** Metavar used for options that take [Float] or [Double] values */
    override fun floatMetavar() = "小数"

    /** Metavar used for options that take [Int] or [Long] values */
    override fun intMetavar() = "整数"

    /** Metavar used for options that take `File` or `Path` values */
    override fun pathMetavar() = "文件或目录"

    /** Metavar used for options that take `InputStream` or `OutputStream` values */
    override fun fileMetavar() = "文件"

    /** The title for the usage section of help output */
    override fun usageTitle(): String = "用法:"

    /** The title for the options‘ section of help output */
    override fun optionsTitle(): String = "选项列表:"

    /** The title for the arguments’ section of help output */
    override fun argumentsTitle(): String = "参数列表:"

    /** The title for the subcommands section of help output */
    override fun commandsTitle(): String = "命令列表:"

    /** The that indicates where options may be present in the usage help output */
    override fun optionsMetavar(): String = "[选项]"

    /** The that indicates where subcommands may be present in the usage help output */
    override fun commandMetavar(): String = "命令 [参数]..."

    /** Text rendered for parameters tagged with [HelpFormatter.Tags.DEFAULT] */
    override fun helpTagDefault(): String = "默认"

    /** Text rendered for parameters tagged with [HelpFormatter.Tags.REQUIRED] */
    override fun helpTagRequired(): String = "必需项"

    /** The default message for the `--help` option. */
    override fun helpOptionMessage(): String = "显示此信息并退出"

}
