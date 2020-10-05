# base image
FROM node:latest as node

# set working directory
WORKDIR /app

# install and cache app dependencies
COPY . .
RUN npm install
RUN npm run build --prod

#FROM nginx:alpine
#COPY --from=node /app/dist/webapp /usr/share/ngnix/html

# Estagio 2 - Será responsavel por expor a aplicação
FROM nginx:1.13
COPY --from=node /app/dist/webapp /usr/share/nginx/html
COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf

