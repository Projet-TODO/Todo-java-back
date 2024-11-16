# Todo-java-back

## Env Setup
```bash
DATABASE_USER=root
DATABASE_PASSWORD=toor
DATABASE_NAME=tododb
DATABASE_PORT=5432
DATABASE_DOCKER_PORTS="5432:5432"
MISTRAL_API_KEY=<Votre clé d'API mistral> # (https://console.mistral.ai/api-keys/)
```

## BDD Setup
1. **Lancer Docker Compose**  
   Exécutez la commande suivante pour démarrer Docker Compose, **après avoir supprimé les images et volumes inutilisés** laissés par d'autres utilisateurs :  
   ```bash
   docker-compose up
   ```

2. **Créer la base de données PostgreSQL**  
   Une fois Docker en cours d'exécution, configurez la base de données dans IntelliJ :  
   - **Mot de passe** : `toor`

   ![Configuration de la DB dans IntelliJ](https://github.com/user-attachments/assets/ec17f736-1780-439f-a2a9-07c6ac811c44)  

   ![Mot de passe PostgreSQL](https://github.com/user-attachments/assets/430845c2-3e36-4260-9e0f-69b6562eb27e)

3. **Exécuter uniquement `Copy_bdd`**  
   Lancez le script `Copy_bdd` pour initialiser la base de données avec les données nécessaires.
