# TP 2 : Hadoop MapReduce /Ventes /Logs

Ce référentiel contient des exemples de code MapReduce pour résoudre deux exercices :

## Exercice 1 : Total des ventes par ville

L'objectif de cet exercice est de développer un Job MapReduce qui calcule le total des ventes par ville à partir d'un fichier texte appelé `ventes.txt`.   
Chaque ligne du fichier `ventes.txt` contient des informations sur les ventes de l'entreprise, y compris la date, la ville, le produit et le prix.

### Étapes pour résoudre l'exercice 1 :

1. Préparation de l'environnement :
   - Assurez-vous d'avoir Hadoop installé et configuré sur votre cluster.
   - Placez le fichier `ventes.txt` sur le système de fichiers Hadoop (HDFS) pour qu'il soit accessible par les tâches MapReduce.

2. Étape de mappage (Mapper) :
   - Le Mapper lit chaque ligne du fichier `ventes.txt`, extrait la ville et le montant de la vente, puis émet un couple clé-valeur, où la clé est la ville et la valeur est le montant de la vente.

3. Étape de tri et regroupement (Shuffle and Sort) :
   - Hadoop trie automatiquement les données par ville pour que les ventes d'une même ville soient traitées ensemble.

4. Étape de réduction (Reducer) :
   - Le Reducer reçoit les ventes triées par ville et calcule le total des ventes pour chaque ville.

5. Configuration du job MapReduce :
   - Configurez votre travail MapReduce en indiquant les classes Mapper et Reducer, les types de données d'entrée et de sortie, etc.

6. Exécution du job sur le cluster Hadoop :
   - Lancez le job MapReduce sur le cluster Hadoop en utilisant la commande `hadoop jar`.

7. Collecte des résultats :
   - Une fois le job terminé, les résultats seront stockés dans un répertoire HDFS que vous avez spécifié comme sortie.

## Exercice 2 : Prix total des ventes de produits par ville pour une année donnée

Pour cet exercice, vous développerez un deuxième Job MapReduce qui calcule le prix total des ventes de produits par ville pour une année donnée,   
en utilisant les données du fichier `ventes.txt`.

### Étapes pour résoudre l'exercice 2 :

1. Créez un programme MapReduce distinct pour cet exercice, en spécifiant un Mapper et un Reducer appropriés.

2. Dans le Mapper, analysez chaque ligne du fichier journal, extrayez l'adresse IP et le code de réponse HTTP, puis émettez un couple clé-valeur.
   La clé doit contenir l'adresse IP et le code de réponse HTTP (par exemple, "192.168.1.1-200"), et la valeur est 1 pour compter la requête.

4. Dans le Reducer, regroupez les données par adresse IP et code de réponse HTTP, puis comptez le nombre de requêtes pour chaque combinaison.
    Émettez un résultat par adresse IP, indiquant le nombre total de requêtes et le nombre de requêtes réussies.

## Exécution des exemples :

- Compilez le code Java en fichiers JAR pour les deux exercices.
- Utilisez la commande `hadoop jar` pour exécuter les jobs sur le cluster Hadoop.
- Les résultats seront stockés dans les répertoires de sortie que vous avez spécifiés.
