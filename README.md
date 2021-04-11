# java-diff - a java difference utility

`java-diff` is a Java implementation for comparison source and target data.

The comparison logic lies in `Engine.java`, with a simple memory/CSV input,
but could be expanded to other iterable inputs.

## Simple Demo

Given a source input in the form:

```
id,col2,col3
 1,   a,   b
 2,   c,   d
```

When compared to a target input such as:

```
id,col2,col3
 2,   x,   d
 3,   e,   f
```

Summarize changed records:

```
id,col2,col3
 2,   x,
```

Summarize added records:

```
id,col2,col3
 3,   e,   f
```

Summarize removed records:

```
id,col2,col3
 1,   a,   b
```

## Future Work

* Add main routine to run the routine outside of memory (stand-alone utility)

* Generalize library for other iterable inputs (e.g., read from csv)
