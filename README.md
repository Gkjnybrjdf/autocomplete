<h1 align="center">
Библиотека autocomplete вводимого текста
</h1>

---
## Вопросы

---
1. Как обрабатывать **\N**? В приложенном файле он не выделяется кавычками, следовательно не является строкой.

*Решение:* Скорее всего данное значение обозначает пустоту ячейки. Соответственно при поиске пустых ячеек необходимо вводить в консоль полностью *\N*, тогда оно будет восприниматься программой как отдельный случай.