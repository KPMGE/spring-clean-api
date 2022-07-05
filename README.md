### Start docker postgres container

```bash
sudo docker run --name postgres-sti-db --rm -p 5432:5432 -e POSTGRES_HOST_AUTH_METHOD=trust postgres:14-alpine
```

### Enter container

```bash
sudo docker exec -it postgres-sti-db bash
```
