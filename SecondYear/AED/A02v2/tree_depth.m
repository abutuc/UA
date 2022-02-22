clear
clc
close all

fn = "tree_depth.txt";
f = fopen(fn);

pessoas = zeros(1, 1900);

depth0 = zeros(1, 1900);
count0 = 1;

depth1 = zeros(1, 1900);
count1 = 1;

depth2 = zeros(1, 1900);
count2 = 1;

depth3 = zeros(1, 1900);
count3 = 1;
while 1
    tline = fgetl(f);
    if ~ischar(tline), break, end
    data = split(tline);
    pessoa = str2double(data{1,1});
    index = str2double(data{2,1});
    depth = str2double(data{3,1});
    tempo = str2double(data{4,1});

    if index == 0
        pessoas(count0) = pessoa;
        depth0(count0) = depth;
        count0 = count0 + 1;
    elseif index == 1
        depth1(count1) = depth;
        count1 = count1 + 1;
    elseif index == 2
        depth2(count2) = depth;
        count2 = count2 + 1;
    elseif index == 3
        depth3(count3) = depth;
        count3 = count3 + 1;
    end
end

semilogx(pessoas, depth0, ".", "Color", "#FFA500")
hold on
semilogx(pessoas-pessoas*0.010, depth1, ".g")
semilogx(pessoas+pessoas*0.025, depth2, ".b")
semilogx(pessoas-pessoas*0.045, depth3, ".", "Color", "red")
hold off
legend("index 0", "index 1", "index 2", "index 3");
xlabel("Number of People")
ylabel("Depth Level")
legend('Location', 'northwest');
title("Maximum Tree Depth")
fclose(f);