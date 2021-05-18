# corp-bs-gen

https://www.atrixnet.com/bs-generator.html

After building native with `gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true` in 
M$ x64 build tools window.

Then build dockerfile `docker build -f src\docker\Dockerfile.native -t duckasteroid/corp-bs-gen .`

Then run it mapping port 8080