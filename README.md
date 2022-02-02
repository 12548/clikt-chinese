# clikt-chinese
A Chinese localization implemention for [Clikt](https://ajalt.github.io/clikt/). 

## Usage
see https://ajalt.github.io/clikt/documenting/#localization

```kotlin
class I18NTool : NoOpCliktCommand(help = "此工具为中文") {
    init {
        context { localization = CliktChineseLocalization() }
    }
}
```
