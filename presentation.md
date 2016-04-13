% Title
% Optional subtitle
% Author

# Slide 1

- item 1
- item 2
- item 3
- item 4
- item 4

![](img/escale.png)

# Slide 2

```javascript
function map(tableau, transformation) {
	return tableau.reduce(function(acc, cur) {
		acc.push(transformation(cur));
		return acc;
	}, []);
}

function filter(tableau, predicat) {
	return tableau.reduce(function(acc, cur) {
		if (predicat(cur)) acc.push(cur);
		return acc;
	}, []);
}
```
