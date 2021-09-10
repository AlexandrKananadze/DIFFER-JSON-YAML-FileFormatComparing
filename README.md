### Hexlet tests and linter status:
[![Actions Status](https://github.com/AlexandrKananadze/java-project-lvl2/workflows/hexlet-check/badge.svg)](https://github.com/AlexandrKananadze/java-project-lvl2/actions)
[![Java CI](https://github.com/AlexandrKananadze/java-project-lvl2/actions/workflows/JavaCI.yml/badge.svg)](https://github.com/AlexandrKananadze/java-project-lvl2/actions/workflows/JavaCI.yml)
<a href="https://codeclimate.com/github/AlexandrKananadze/java-project-lvl2/maintainability"><img src="https://api.codeclimate.com/v1/badges/e221a0c7e8437dabda21/maintainability" /></a>
<a href="https://codeclimate.com/github/AlexandrKananadze/java-project-lvl2/test_coverage"><img src="https://api.codeclimate.com/v1/badges/e221a0c7e8437dabda21/test_coverage" /></a>

JSON/YAML Differ

Supported formats: yaml, json. Output supported formats: plain, stylish, json.

Пример дифа для вложенных структур plain:

$ ./build/install/app/bin/app filepath1.json filepath2.json

{
    chars1: [a, b, c]
  - chars2: [d, e, f]
  + chars2: false
  - checked: false
  + checked: true
  - default: null
  + default: [value1, value2]
  - id: 45
  + id: null
  - key1: value1
  + key2: value2
    numbers1: [1, 2, 3, 4]
  - numbers2: [2, 3, 4, 5]
  + numbers2: [22, 33, 44, 55]
  - numbers3: [3, 4, 5]
  + numbers4: [4, 5, 6]
  + obj1: {nestedKey=value, isNested=true}
  - setting1: Some value
  + setting1: Another value
  - setting2: 200
  + setting2: 300
  - setting3: true
  + setting3: none
}

file1.json:

{
  "setting1": "Some value",
  "setting2": 200,
  "setting3": true,
  "key1": "value1",
  "numbers1": [1, 2, 3, 4],
  "numbers2": [2, 3, 4, 5],
  "id": 45,
  "default": null,
  "checked": false,
  "numbers3": [3, 4, 5],
  "chars1": ["a", "b", "c"],
  "chars2": ["d", "e", "f"]
}

file2.json

{
  "setting1": "Another value",
  "setting2": 300,
  "setting3": "none",
  "key2": "value2",
  "numbers1": [1, 2, 3, 4],
  "numbers2": [22, 33, 44, 55],
  "id": null,
  "default": ["value1", "value2"],
  "checked": true,
  "numbers4": [4, 5, 6],
  "chars1": ["a", "b", "c"],
  "chars2": false,
  "obj1": {
    "nestedKey": "value",
    "isNested": true
  }
}
