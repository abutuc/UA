clear
close all
clc

fn = "nodes.txt";
f = fopen(fn);
count = 1;

node = zeros(61);
levels = zeros(61);
while 1
    tline = fgetl(f);
    if ~ischar(tline), break, end
    data = split(tline);
    levels(count) = str2double(data{1,1});
    node(count) = str2double(data{2,1});
    count = count+1;
end

figure(1);
plot(levels, node, ".");
title("Name Binary Tree Densitiy 10000000 people")
xlabel("Levels");
ylabel("Nodes")