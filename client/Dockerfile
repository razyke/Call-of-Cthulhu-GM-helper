FROM node
WORKDIR /app
COPY ./package*.json ./
RUN npm install -g @angular/cli
RUN npm install
COPY . /app
RUN npm run build
EXPOSE 4200 4200
CMD ng serve --open --host 0.0.0.0
