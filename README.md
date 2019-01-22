# Silver
[![Total alerts](https://img.shields.io/lgtm/alerts/g/pvlakshm/Silver.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/pvlakshm/Silver/alerts/) [![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/pvlakshm/Silver.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/pvlakshm/Silver/context:java)

## The Silver Programming Language
A simple language and its Visual Studio Language Service.

### Composition
- tokens
- a scanner that can tokenize.
- grammar, and a parser that can scan a stream of tokens and accept that grammar.
- reify the accepted grammar as an AST.
- symbol table, and traverse the AST and do semantic analysis.
- traverse the AST and do codegen.
- introduce a language service based on the LSP (see [here](https://github.com/pvlakshm/LSP) for an example.
