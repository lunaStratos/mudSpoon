FROM node:16.6.1-alpine

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

ADD package.json /app/package.json
RUN npm install --legacy-peer-deps
RUN npm install react-scripts@3.4.1 -g

CMD ["npm", "start"]
EXPOSE 3000
