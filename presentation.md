% Gérer les erreurs avec l'aide du système de types de Scala !
% David Sferruzza
% 22/04/2016

# À propos de moi

- [\@d_sferruzza](https://twitter.com/d\_sferruzza)
- [github.com/dsferruzza](https://github.com/dsferruzza)
- développeur et responsable R&D chez [Escale](http://www.escaledigitale.com)
- doctorant en génie logiciel à l'Université de Nantes
- écrit des projets perso et pro en Scala et en Haskell (notamment) depuis ~ 2 ans

![](img/escale.png)


# Cas d'exemple

Un joueur est ajouté à notre application.

```json
{ "name": "Batman", "level": 99, "hp": 85 }
```

Le JSON est parsé et les erreurs de structure gérées.

```scala
case class Player(name: String, level: Int, hp: Int)
```

On veut valider ces données avec des critères métier.

```scala
// On veut implémenter cette fonction
def validate(player: Player): ValidPlayer = ???

case class ValidPlayer(name: String, level: Int, hp: Int)
// ^ Même structure que Player
```


# Cas d'exemple

```scala
case class Player(name: String,
                  level: Int,
                  hp: Int)
```

Pour qu'un joueur soit valide (et devienne un `ValidPlayer`), il doit respecter ces *3* critères :

- longueur de nom supérieur à 3 caractères
- niveau strictement positif
- moins de points de vie que `95 + niveau * 5`


# Cas d'exemple

`validate` peut échouer à produire une valeur de type `ValidPlayer`.

```scala
def validate(player: Player): ValidPlayer = ???
```

Comment le gérer ?

> Deux points de vue :
>
> - définition de `validate`
> - appel de `validate`


# null

Si `validate` échoue, on renvoie `null`.

```scala
def validate(player: Player): ValidPlayer = {
  if ( /* ... */ ) {
    ValidPlayer( /* ... */ )
  }
  else null
}
```
```scala
val player = Player( /* ... */ )
val validPlayer = validate(player)

if (validPlayer != null) {
  // On peut utiliser validPlayer
}
```
