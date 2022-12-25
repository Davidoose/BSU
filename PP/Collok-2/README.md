# Collok-2

Задача:
	Произвести поиск по базе об утилизированных машинах различными методами с реализованным интерфейсом.
Решение:
	Поскольку необходимо реализовать поиск при помощи различных алгоритмов, отлично подойдет Design Pattern "Strategy", 
который определяет семейство схожих алгоритмов и помещает каждый из них в собственный класс, 
после чего алгоритмы можно взаимозаменять прямо во время исполнения программы.
Таким образом можно избежать ненужного повторения в коде.