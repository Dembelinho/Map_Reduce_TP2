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

## Prix total des ventes de produits par ville pour une année donnée

Pour cet exercice, vous développerez un deuxième Job MapReduce qui calcule le prix total des ventes de produits par ville pour une année donnée,   
en utilisant les données du fichier `ventes.txt`.

## Exécution des exemples :

- Compilez le code Java en fichiers JAR pour les deux exercices.
- Utilisez la commande `hadoop jar` pour exécuter les jobs sur le cluster Hadoop.
- Les résultats seront stockés dans les répertoires de sortie que vous avez spécifiés.


## Exercice 2 : Analyse des Logs Web avec Hadoop MapReduce

Ce projet a été créé pour démontrer comment utiliser Hadoop MapReduce pour analyser des fichiers journaux Web et calculer le nombre total de requêtes par adresse IP, ainsi que le nombre de requêtes réussies (code de réponse HTTP 200) par adresse IP.

#"# Données d'Entrée

Les données d'entrée sont un ensemble de fichiers journaux Web au format texte. Chaque ligne du fichier journal contient des informations sur les requêtes HTTP, notamment l'adresse IP du client, la date, le chemin d'accès demandé, le code de réponse HTTP, etc. Voici un exemple de données d'entrée :

192.168.1.1 - - [12/May/2023:15:30:45 +0000] "GET /page1 HTTP/1.1" 200 1234
192.168.1.2 - - [12/May/2023:15:31:02 +0000] "GET /page2 HTTP/1.1" 404 567
192.168.1.1 - - [12/May/2023:15:32:10 +0000] "GET /page1 HTTP/1.1" 200 789
192.168.1.3 - - [12/May/2023:15:32:35 +0000] "GET /page3 HTTP/1.1" 200 987

### Travail à Faire

L'objectif de ce projet est d'utiliser Hadoop MapReduce pour effectuer les tâches suivantes :

1. Calculer le nombre total de requêtes par adresse IP.
2. Calculer le nombre de requêtes réussies (code de réponse HTTP 200) par adresse IP.

### Comment Exécuter le Code

Pour exécuter le code, assurez-vous d'avoir Hadoop installé et configuré sur votre cluster. Suivez ces étapes :

1. Compilez le code Java de l'application MapReduce en un fichier JAR.

2. Utilisez la commande `hadoop jar` pour soumettre votre travail MapReduce sur le cluster Hadoop. Assurez-vous de spécifier les chemins d'entrée et de sortie appropriés.

Exemple d'exécution du job :

```bash
hadoop jar WebLogAnalysis.jar input/logs/ output/results/
```
Résultats
Une fois le job MapReduce terminé, les résultats seront stockés dans le répertoire de sortie spécifié. Vous obtiendrez le nombre total de requêtes et le nombre de requêtes réussies par adresse IP.

N'hésitez pas à explorer ce projet pour voir comment utiliser Hadoop MapReduce pour analyser des logs Web. Si vous avez des questions ou des commentaires, n'hésitez pas à les partager.

Auteur : BARKA Ayoub
